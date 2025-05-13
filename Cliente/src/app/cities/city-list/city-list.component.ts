import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { CityService } from '../city.service';
import { City } from '../model/City';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { HttpClientModule } from '@angular/common/http';
import { CityItemComponent } from './city-item/city-item.component';
import { Subscription } from 'rxjs/internal/Subscription';
import { ActivatedRoute } from '@angular/router';
import { HeadernfiltersService } from '../../core/headernfilters.service';


@Component({
    selector: 'app-city-list',
    standalone: true,
    imports: [
        MatButtonModule,
        MatIconModule,
        MatTableModule,
        CommonModule,
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatSliderModule,
        MatButtonToggleModule,
        HttpClientModule,
        CityItemComponent
    ],
    templateUrl: './city-list.component.html',
    styleUrl: './city-list.component.scss',
})
export class CityListComponent implements OnInit {
    countryCode: string;
    cities: City[] = [];
    private subscription: Subscription;
    
    constructor(
      private route: ActivatedRoute,
      private cityService: CityService,
      private filterService: HeadernfiltersService
    ) {}
    
ngOnInit(): void {
      this.subscription = this.filterService.filters$.subscribe(filters => {
          this.loadCitiesWithFilters(filters);
      });
    }
    
    loadCitiesWithFilters(filters: any): void {
      filters.country = this.route.snapshot.paramMap.get('id');
      this.cityService.getCitiesByCountry(filters).subscribe(data => {
        this.cities = data;
      });
    }
    
    
    ngOnDestroy(): void {
      if (this.subscription) {
        this.subscription.unsubscribe();
      }
    }

    }

