import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Country } from './model/Country';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  constructor(
    private http: HttpClient
) {}

private baseUrl = 'http://localhost:8080/countries';

getCountries(request): Observable<Country[]> {
  console.log(request)
  return  this.http.post<Country[]>(this.baseUrl, request);
}

getCountryInfo(code: string): Observable<any> {
  return this.http.get<any[]>(`https://restcountries.com/v3.1/alpha/${code}`)
    .pipe(
      map(response => {
        if (response && response.length > 0) {
          const country = response[0];
          
          // Extract currency name
          const currencyCode = Object.keys(country.currencies)[0];
          const currencyName = country.currencies[currencyCode].name;
          
          // Extract capital
          const capital = country.capital?.[0] || '';
          
          // Extract language
          const languageCode = Object.keys(country.languages)[0];
          const language = country.languages[languageCode];
          
          return {
            currencyName,
            capital,
            language
          };
        }
        return null;
      })
    );
}
  // Método para conectar con el endpoint definido
  testConexion(): Observable<string> {
    return this.http.get(`${this.baseUrl}`, { responseType: 'text' });
  }
}
