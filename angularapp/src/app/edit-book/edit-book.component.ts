import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from "@angular/router";


@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  private txtName:String;
  private txtAuthor:String;
  private txtBookImageUrl:String;

  private data:any[];

  constructor(private dataService: DataService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
  }

  result: string;

  private bookId = "";

  editBook(){
  		this.bookId = this.route.snapshot.paramMap.get("id");

        var book = {
          "bookId":this.bookId,
          "bookName":this.txtName,
          "author" : this.txtAuthor,
          "imageUrl":this.txtBookImageUrl  
        };

        console.log("Form creation data "+this.txtName);

        this.dataService.editBook(book).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully edited the book to the system";
               this.router.navigate(['admin-home']);
            },
          (response) => {
              console.log("response "+response.status);   
              this.result = "Try again";
           }
        );
    }

}
