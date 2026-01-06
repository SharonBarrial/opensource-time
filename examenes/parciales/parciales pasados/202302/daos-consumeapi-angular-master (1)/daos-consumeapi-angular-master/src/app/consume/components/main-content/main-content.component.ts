import { Component, OnInit ,AfterViewInit,ViewChild} from '@angular/core';
import { ConsumeApiService } from "../../services/consume-api.service";
import {Source} from "../../model/source.entity";
import {MatTableDataSource} from "@angular/material/table";
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.css']
})
export class MainContentComponent implements OnInit{
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'photoUrl', 'centerId', 'ranking', 'recordTime' ];
  dataSource: MatTableDataSource<any>;

  status: string = '';
  sources: Array<Source> = [];

  @ViewChild(MatPaginator, {static: true})
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort!: MatSort;


  constructor(private consumeService: ConsumeApiService) {
    this.dataSource = new MatTableDataSource<any>();
  }

  private getAllSources(): void {
    this.consumeService.getSources().subscribe((data: any) => {
      console.log(data);
      this.dataSource.data = data;
    });
  }
  
  

  ngOnInit(): void {
    this.getAllSources();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
   
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

 
  
}
