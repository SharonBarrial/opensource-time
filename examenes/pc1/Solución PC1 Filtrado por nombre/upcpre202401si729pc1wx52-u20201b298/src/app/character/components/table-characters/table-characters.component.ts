import {Component, OnInit} from '@angular/core';
import {CharacterService} from "../../services/character.service";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {Character} from "../../models/character.model";
import {MatFormField} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
@Component({
  selector: 'app-table-characters',
  standalone: true,
  imports: [MatTableModule, MatFormField, MatInputModule],
  templateUrl: './table-characters.component.html',
  styleUrl: './table-characters.component.css'
})

/*in this class we have imported the necessary modules for table, models and API consumption through character service.
   in the constructor we inject the service and in ngOnInit that is executed when starting the page, we will call the function that obtains the data from the api
   and we indicate that the type of filtering will be by name, the function of applying filter works as an event when writing in the search input, it is activated
   and the filtered values are stored to be displayed in the table*/
export class TableCharactersComponent implements OnInit {
  displayedColumns: string[] = ['image', 'name', 'specie', 'status'
    ,'location'];
  dataSource: MatTableDataSource<Character> = new MatTableDataSource<Character>();
  characters: Character[] = [];
  prueba:Character[]=[]

  constructor(private characterService: CharacterService) {
  }
  ngOnInit() {
    // When the page initializes, we fetch characters from the service.
    this.getCharacters();
  }
  // Function to fetch characters from the service.
  getCharacters(): void {
    this.characterService.getCharacters().subscribe((data: any) => {
      console.log(data);
      // Map the obtained results to Character objects.
      this.characters = data.results.map((result: any) => new Character(result.image, result.name, result.species, result.status, result.location));
      // Assign characters to the table data source.
      this.dataSource = new MatTableDataSource<Character>(this.characters);
    })
  }
  // Function to apply filtering when typing in the search input.
  applyFilter(event: Event){
    // Get the value from the search input and filter it.
    const inputElement = event.target as HTMLInputElement;
    const filteredValue = inputElement.value.replace(/[^a-zA-Z ]/g, '');
    inputElement.value = filteredValue;
    // Configure filtering by name.
    this.dataSource.filterPredicate = (data: Character, filter: string) => {
      return data.name.toLowerCase().includes(filter);
    };
    // Apply the filter to the table data.
    this.dataSource.filter = filteredValue.trim().toLowerCase();


  }
}
