import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

   books = [];
   private txtSearch:String;
   private category:String;

   constructor(private dataService: DataService) { }

     ngOnInit() {
      this.dataService.fetchAllBooks().subscribe((data: any[])=>{
        console.log(data);
        this.books = data;
      })  
     }

    searchBook(){
        console.log("response "+this.txtSearch);
        
        this.dataService.searchBook(this.txtSearch).subscribe(
          (data: any[]) => {
                console.log("response "+this.txtSearch);
               this.books = data;
               //this.result = "You have succesfully registered to the system";
               //this.router.navigate(['admin-home']);
            },
          (response) => {
              console.log("response "+response.status);   
              //this.result = "Try again";
           }
        );
    }

    categoryBooks(category){
       console.log("response "+category);
        
        this.dataService.categoryBooks(category).subscribe(
          (data: any[]) => {
              console.log("response "+category);
              this.books = data;  
            },
          (response) => {
              console.log("response "+response.status);   
           }
        );
    }



}
