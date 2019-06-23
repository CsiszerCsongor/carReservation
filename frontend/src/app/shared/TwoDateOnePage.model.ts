export class TwoDateOnePageModel {
  startDate: Date;
  endDate: Date;
  page: number;
  nrOfElementsOnPage: number;
  
  constructor(startDate: Date, endDate: Date, page: number, nrOfElementsOnPage: number) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.page = page;
    this.nrOfElementsOnPage = nrOfElementsOnPage;
  }
}