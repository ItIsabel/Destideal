import { Routes } from '@angular/router';

export const routes: Routes = [
    { path: 'cities/:id', loadComponent: () => import('./cities/city-list/city-list.component').then(m => m.CityListComponent)},
    { path: 'countries', loadComponent: () => import('./countries/country-list/country-list.component').then(m => m.CountryListComponent)},
    { path: '**', redirectTo: 'countries' }
];
