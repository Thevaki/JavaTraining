import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

    books = [];

   constructor(private dataService: DataService) { }

   ngOnInit() {

   	//var x = 1;
    this.dataService.findBook().subscribe((data: any)=>{
      console.log(data);
      this.books = data;
    })  
  }

}