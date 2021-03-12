
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA,MatDialogRef } from '@angular/material/dialog';
import { Grad } from '../grad';
import { SearchComponent } from '../search/search.component';
@Component({
  selector: 'app-detail-grad',
  templateUrl: './detail-grad.component.html',
  styleUrls: ['./detail-grad.component.css']
})
export class DetailGradComponent implements OnInit {

  grad:Grad;
  constructor(public dialogRef:MatDialogRef<SearchComponent>, @Inject(MAT_DIALOG_DATA) data
    ) { 
      this.grad = data.grad;
   
   }


  ngOnInit(): void {
  }

  onClose() {

    this.dialogRef.close();
  }
}
