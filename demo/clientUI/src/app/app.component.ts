import { Component } from '@angular/core';
import {CleanService} from './clean.service';
import { CleanData, PersonRecord, DuplicateGroup } from './cleanData';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Clean Demo';
  filename = '../data/normal.csv';
  cleanData: CleanData;

  constructor(
    private cleanService: CleanService
  ) {
  }
  cleanFile(event: any) {
    console.log(this.filename);
    this.cleanService.getCleanFileData(this.filename).subscribe(res => {
      this.cleanData = res as CleanData;
    });
  }

}
