export class CarModel {
    private id: number;
    private name: string;
    private pricePerDay: number;
    private isActive: boolean;
    private currency: string;
    private carCode: string;
  
    constructor(id: number, name: string, pricePerDay: number, isActive: boolean, currency: string, carCode: string) {
      this.id = id;
      this.name = name;
      this.pricePerDay = pricePerDay;
      this.isActive = isActive;
      this.currency = currency;
      this.carCode = carCode;
    }

    get geId():number {
        return this.id;
    }

    get getName():string {
        return this.name
    }

    get getPricePerDay():number {
        return this.pricePerDay;
    }

    get getIsActive():boolean {
        return this.isActive;
    }

    get getCurrency():string {
        return this.currency;
    }

    get getCarCode():string {
        return this.carCode;
    }
  }