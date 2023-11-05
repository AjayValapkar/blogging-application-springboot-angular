import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { Category } from 'src/app/models/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[] = [];
  selectedCategoryId: number | undefined;

  constructor(private blogpostservice: BlogserviceService) {}

  ngOnInit(): void {
    this.blogpostservice.getCategory().subscribe(data => {
      this.categories = data;
    });
  }
  allBlogs(){
    // this.blogpostservice.getAllBlog().subscribe(data => {
    //   this.categories = data;
    // });
  }

  @Output() categorySelected: EventEmitter<number> = new EventEmitter<number>();

  getCategoryId(categoryId: number) {
  
    this.categorySelected.emit(categoryId);
  }

}
