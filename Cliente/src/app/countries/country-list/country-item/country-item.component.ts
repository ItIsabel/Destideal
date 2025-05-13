import { Component, Input } from '@angular/core';
import { Country } from '../../model/Country';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-country-item',
  imports: [
    MatCardModule,
    CommonModule,
],
  templateUrl: './country-item.component.html',
  styleUrls: ['./country-item.component.scss']
})
export class CountryItemComponent {
  @Input() country!: Country;
}
