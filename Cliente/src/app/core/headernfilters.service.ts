import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeadernfiltersService {
  private filterSubject = new BehaviorSubject<any>(null);
  public filters$ = this.filterSubject.asObservable();
  
  constructor() {}
  
  updateFilters(filters: any): void {
    this.filterSubject.next(filters);
  }
}