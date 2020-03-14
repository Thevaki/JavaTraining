import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

   books = [];

   constructor(private dataService: DataService) { }

   ngOnInit() {

    this.dataService.sendGetRequest().subscribe((data: any[])=>{
      console.log(data);
      this.books = data;
    })  
  }


}
