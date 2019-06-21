export class CarStateModel {
    carid: number;
    state: boolean;
  
    constructor(carid: number, state: boolean) {
      this.carid = carid;
      this.state = state;
    }
  }