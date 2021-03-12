import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { GradService } from '../grad.service';
import { NotificationService } from '../notification.service';
import { SearchComponent } from '../search/search.component';

@Component({
  selector: 'app-delete-grad',
  templateUrl: './delete-grad.component.html',
  styleUrls: ['./delete-grad.component.css']
})
export class DeleteGradComponent implements OnInit {

  constructor(public gradService:GradService,public dialogRef:MatDialogRef<SearchComponent>,
    private notificationService: NotificationService) { }

  ngOnInit(): void {
    
  }
  
  onDelete() {
        console.log(this.gradService.id);
        this.gradService.deleteGrads(this.gradService.id).subscribe((res)=>{
          this.gradService.form.reset();
          this.gradService.initializeFormGroup();
          this.notificationService.success(':: deleted successfully refresh if change not reflected');
          this.onClose();   
        });
  }

  onClose() {
    this.gradService.form.reset();
    this.gradService.initializeFormGroup();
    this.dialogRef.close();
  }

}
