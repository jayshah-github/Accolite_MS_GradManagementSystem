import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

    form: FormGroup = new FormGroup({
      $key: new FormControl(null),
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      feedback: new FormControl('', Validators.required),
      email: new FormControl('', Validators.email),
      contact: new FormControl('', [Validators.required, Validators.minLength(8)]),
     // city: new FormControl(''),
      gender: new FormControl('1'),
      //department: new FormControl(0),
      ten_join_date: new FormControl(''),
    //  isPermanent: new FormControl(false)
    });
  
    initializeFormGroup() {
      this.form.setValue({
        $key: null,
        name: '',
        description: '',
        feedback: '',
        email: '',
        contact: '',
       // city: '',
        gender: '1',
        //department: 0,
        ten_join_date: '',
      //  isPermanent: false
      });
    }
  }

