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
import { Country } from '../model/Country';
import { CountryService } from '../country.service';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { HeadernfiltersService } from '../../core/headernfilters.service';
import { HeadernfiltersComponent } from '../../core/headernfilters/headernfilters.component';
import { CountryItemComponent } from './country-item/country-item.component';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-country-list',
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
    CountryItemComponent
  ],
  templateUrl: './country-list.component.html',
  styleUrl: './country-list.component.scss'
})
export class CountryListComponent {
  countries: Country[] = [];
  private subscription: Subscription;
  
  constructor(
    private countryService: CountryService,
    private filterService: HeadernfiltersService,
    private router: Router
  ) {}
  
  ngOnInit(): void {
    this.subscription = this.filterService.filters$.subscribe(filters => {
        this.loadCountriesWithFilters(filters);
    });
  }
  
  loadCountriesWithFilters(filters: any): void {
    this.countryService.getCountries(filters).subscribe(data => {
      this.countries = data;
  
      this.countries.forEach(country => {
        const countryCode = country.id;
        this.countryService.getCountryInfo(countryCode).subscribe({
          next: countryInfo => {
            country.currency = countryInfo.currencyName;
            country.capital = countryInfo.capital;
            country.language = countryInfo.language;
          },
        });
      });
    });
  }
  
  
  
  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

    goToCountryCities(code: string): void {
      this.router.navigate(['/cities', code]);
    }

}
