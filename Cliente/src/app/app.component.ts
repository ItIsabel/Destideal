import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HeadernfiltersService } from './core/headernfilters.service';
import { HeadernfiltersComponent } from './core/headernfilters/headernfilters.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeadernfiltersComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  constructor(
    private filterService: HeadernfiltersService,
    private router: Router
  ) {}
  
  handleFilterChange(filters: any): void {
    this.filterService.updateFilters(filters);
}
}
