import { Component, OnInit, Output,EventEmitter} from '@angular/core';
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
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-headernfilters',
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
    MatButtonToggleModule],
  templateUrl: './headernfilters.component.html',
  styleUrl: './headernfilters.component.scss'
})
export class HeadernfiltersComponent {
  @Output() filterChange = new EventEmitter<any>();

    // Variables para los rangos de temperatura y lluvia
    minTemp: number = -15;
    maxTemp: number = 45;
    minRain: number = 0;
    maxRain: number = 200;
    selectedMonth: string = null;
    country:string =null;

    constructor(
      private route: ActivatedRoute,
      private router: Router
    ) {}

    ngOnInit(): void {
      const request = {
        minTemp: this.minTemp || null,
        maxTemp: this.maxTemp || null,
        minRain: this.minRain || null,
        maxRain: this.maxRain || null,
        month: this.selectedMonth || null,
        country: this.country || null,
    };
    this.filterChange.emit(request);
    }
  onCleanFilter(): void {
    // Restablecer los filtros a sus valores predeterminados
    this.minTemp = -15;
    this.maxTemp = 45;
    this.minRain =0;
    this.maxRain = 200;
    this.selectedMonth=null
    this.onSearch();
}

onSearch(): void {
    const noFilterSelected =
      (this.selectedMonth === null || this.selectedMonth === '') 

    if (noFilterSelected) {
      alert('Por favor, seleccione el mes antes de buscar.');
      return;
    }

    const request = {
        minTemp: this.minTemp || null,
        maxTemp: this.maxTemp || null,
        minRain: this.minRain || null,
        maxRain: this.maxRain || null,
        month: this.selectedMonth || null,
        country: this.country || null,
    };
    this.filterChange.emit(request);
}
}
