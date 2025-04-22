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
    cities: City[];

    
    // Variables para los rangos de temperatura y lluvia
    minTemp: number = 0;
    maxTemp: number = 50;
    minRain: number = 0;
    maxRain: number = 100;
    selectedMonth: string = null;

    constructor(
        private cityService: CityService,
        public dialog: MatDialog
    ) {}

    ngOnInit(): void {
        this.getCities();
    }

    getCities(): void {
        const request = {
            minTemp: this.minTemp || null,
            maxTemp: this.maxTemp || null,
            minRain: this.minRain || null,
            maxRain: this.maxRain || null,
            month: this.selectedMonth || null,
        };
        this.cityService.getCities(request).subscribe((cities) => (this.cities = cities));
    }

    onCleanFilter(): void {
        // Restablecer los filtros a sus valores predeterminados
        this.minTemp = 0;
        this.maxTemp = 50;
        this.minRain = 0;
        this.maxRain = 100;
        this.onSearch();
    }

    onSearch(): void {
        const request = {
            minTemp: this.minTemp || null,
            maxTemp: this.maxTemp || null,
            minRain: this.minRain || null,
            maxRain: this.maxRain || null,
            month: this.selectedMonth || null,
        };
        this.cityService.getCities(request).subscribe((cities) => (this.cities = cities));
    }

}