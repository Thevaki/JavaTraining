import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

    //private userId:number;
    private txtName:String;
    private txtAuthor:String;
    private txtBookImageUrl:String;

    private data:any[];

    constructor(private dataService: DataService,private router: Router,private route: ActivatedRoute) { }

    result: string;

    private bookId = "";

    ngOnInit() {}

    createBook(){
        var book = {
          "bookName":this.txtName,
          "author" : this.txtAuthor,
          "imageUrl":this.txtBookImageUrl  
        };

        console.log("Form creation data "+this.txtName);

        this.dataService.createBook(book).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully added a book to the system";
               this.router.navigate(['admin-home']);
            },
          (response) => {
              console.log("response "+response.status);   
              this.result = "Try again";
           }
        );
    }

   
}
