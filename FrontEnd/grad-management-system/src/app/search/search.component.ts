import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Grad } from '../grad';
import { GradService } from '../grad.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public grads:Grad[]
  constructor(private gradService:GradService) { }

  ngOnInit(): void {
    this.getGrads();
  }

  public getGrads():void{
    this.gradService.getGrads().subscribe(
      (respone:Grad[])=>{
        this.grads=respone;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }

}
