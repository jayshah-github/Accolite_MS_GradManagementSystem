import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Grad } from './grad';

@Injectable({
  providedIn: 'root'
})
export class GradService {

  private apiServerUrl=environment.apiBaseUrl;
  constructor(private http:HttpClient) { }

    public getGrads():Observable<Grad[]>{
      return this.http.get<Grad[]>(`${this.apiServerUrl}/grad/all`);
    }

    public addGrads(grad:Grad):Observable<Grad>{
      return this.http.post<Grad>(`${this.apiServerUrl}/grad/add`,grad);
    }

    
    public updateGrads(grad:Grad):Observable<Grad>{
      return this.http.put<Grad>(`${this.apiServerUrl}/grad/update`,grad);
    }

    
    public deleteGrads(id:number):Observable<void>{
      return this.http.delete<void>(`${this.apiServerUrl}/grad/delete/${id}`);
    }
  }

