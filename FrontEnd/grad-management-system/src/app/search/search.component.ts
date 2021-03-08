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
