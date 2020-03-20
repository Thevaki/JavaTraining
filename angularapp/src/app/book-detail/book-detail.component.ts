import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

   constructor(private dataService: DataService) { }

    bookName: string;
    author:String;
    imageUrl:String;

    //books = [];

    ngOnInit() {

      this.dataService.findBook().subscribe((data: any)=>{
      console.log(data);
      //this.books = data.result;
      console.log(data.bookName);

      this.bookName = data.bookName;
      this.author = data.author;
      this.imageUrl = data.imageUrl;
      console.log( this.bookName);
    });

   }


  /* get(){
   console.log("hi");

   var books = {
        "bookId":this.bookId,
        "bookName" : this.bookName,
        "author":this.author,
        "imageUrl":this.imageUrl 
    };

        //var x = 1;
    this.dataService.findBook().subscribe((data: any)=>{
      console.log(data);
      this.books = data;
      console.log(this.books.bookName);
      //books.bookName = this.txtbookName;
    });

    } */

}