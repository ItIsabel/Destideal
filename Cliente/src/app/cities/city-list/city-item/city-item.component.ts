import { Component, Input } from '@angular/core';
import { City } from '../../model/City';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-city-item',
  imports: [
    MatCardModule,
    CommonModule,
],
  templateUrl: './city-item.component.html',
  styleUrls: ['./city-item.component.scss']
})
export class CityItemComponent {
  @Input() city!: City;
}
