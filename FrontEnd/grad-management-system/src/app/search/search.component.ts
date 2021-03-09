import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Grad } from '../grad';
import { GradService } from '../grad.service';
import {AfterViewInit, ViewChild} from '@angular/core';

import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {
  displayedColumns: string[] = [ 'name','actions'];
  grads: MatTableDataSource<Grad>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  searchKey:String;
  
  constructor(private gradService:GradService) {

}

  ngOnInit(): void {
    this.getGrads(); 
  }

 

  onSearchClear(){
    this.searchKey="";
    this.applyFilter();
  }
  applyFilter(
    //event: Event
    ) {
  //  const filterValue = (event.target as HTMLInputElement).value;
    this.grads.filter = this.searchKey.trim().toLowerCase();

    if (this.grads.paginator) {
      this.grads.paginator.firstPage();
    }
  }

public onOpenModal(grad:Grad,mode:string):void{
  const container=document.getElementById("main-cont")
  const button =document.createElement('button');
  button.type='button';
  button.style.display='none';
  button.setAttribute('data-bs-toggle','modal');
  if(mode==='add')
  {
    button.setAttribute('data-bs-target','#addModal');
  }
  if(mode==='edit')
  {
    button.setAttribute('data-bs-target','#editModal');
  }
  if(mode==='delete')
  {
    button.setAttribute('data-bs-target','#deleteModal');
  }
  container.appendChild(button);
  button.click();
}
  public getGrads():void{
    this.gradService.getGrads().subscribe(
      (respone:Grad[])=>{
        this.grads=new MatTableDataSource(respone);
        this.grads.sort=this.sort;
        this.grads.paginator=this.paginator;
        this.grads.filterPredicate=(data,filter)=>{
            return this.displayedColumns.some(ele=>{
              return ele!='actions'&& data[ele].toLowerCase().indexOf(filter)!=-1;
            })
        };
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }

}
