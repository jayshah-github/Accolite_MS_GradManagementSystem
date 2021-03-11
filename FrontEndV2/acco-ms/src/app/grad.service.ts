import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Grad } from './grad';
import { Institute } from './institute';
import { Skill } from './skill';

@Injectable({
  providedIn: 'root'
})
export class GradService {

  private apiServerUrl=environment.apiBaseUrl;
  formBuilder: any;
  constructor(private http:HttpClient,private fb:FormBuilder) { }

    public getGrads():Observable<Grad[]>{
      return this.http.get<Grad[]>(`${this.apiServerUrl}/grad/all`);
    }

    public addGrads(grad:Grad):Observable<Grad>{
      console.log(JSON.stringify(grad));
      return this.http.post<Grad>(`${this.apiServerUrl}/grad/add`,grad);
    }

    
    public updateGrads(grad:Grad):Observable<Grad>{
      return this.http.put<Grad>(`${this.apiServerUrl}/grad/update`,grad);
    }

    
    public deleteGrads(id:number):Observable<void>{
      return this.http.delete<void>(`${this.apiServerUrl}/grad/delete/${id}`);
    }
    public getLocations():Observable<Location[]>{
      return this.http.get<Location[]>(`${this.apiServerUrl}/list/allLoc`);
    }
    public getInstitutes():Observable<Institute[]>{
      return this.http.get<Institute[]>(`${this.apiServerUrl}/list/allInsti`);
    }
    
    public getSkills():Observable<Skill[]>{
      return this.http.get<Skill[]>(`${this.apiServerUrl}/list/allSkill`);
    }
    public getLabels(label:String):Observable<any>{
      return this.http.get<any>(`${this.apiServerUrl}/list/chart/bar/${label}`);
    }
    public getLabelsPie(label:String):Observable<any>{
      return this.http.get<any>(`${this.apiServerUrl}/list/chart/pie/${label}`);
    }


    id:number;
    form: FormGroup = new FormGroup({
      $key: new FormControl(null),
      id:new FormControl(null),
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      feedback: new FormControl('', Validators.required),
      email: new FormControl('',[Validators.required, Validators.email]),
      contact: new FormControl('', [Validators.required, Validators.minLength(8)]),
      join_loc:new FormControl('',Validators.required),
      loc:new FormControl('',Validators.required),
      institute:new FormControl('',Validators.required),
      skills:new FormControl(''),
     // city: new FormControl(''),
     // gender: new FormControl('1'),
      //department: new FormControl(0),
      ten_join_date: new FormControl(''),
    //  isPermanent: new FormControl(false)
    });
  
    initializeFormGroup() {
      this.form.setValue({
        $key: null,
        id:null,
        name: '',
        description: '',
        feedback: '',
        email: '',
        contact: '',
        join_loc:'',
        loc:'',
        institute:'',
        skills:[],
       // city: '',
       // gender: '1',
        //department: 0,
        ten_join_date: '',
      //  isPermanent: false
      });
    }
    populateForm(grad,id) {
      this.form.setValue({
        $key: id,
        id:grad.id,
        name: grad.name,
        description: grad.description,
        feedback: grad.feedback,
        email: grad.email,
        contact: grad.contact,
        join_loc:grad.join_loc,
        loc:grad.loc,
        institute:grad.institute,
         skills:grad.skills,
       // city: '',
       // gender: grad.gender,
        //department: 0,
        ten_join_date: grad.ten_join_date,
      //  isPermanent: false
      });
    
      

    }
    populateFormId(grad) {
      this.id=grad.id;
    }
    setValue(item: Skill[]) :FormArray{
      const formArray = new FormArray([]);
      for (let x of item) {
        formArray.push(this.fb.group({
          id: x.id,
          name: x.name
        }));
      }
     return formArray;
    }
  }

