export interface IProduct {
  id?: number;
  name?: string;
  details?: string;
  sku?: string;
  category?: string;
  price?: number;
  stocks?: number;
}

export interface ICart {
  productId?: number;
  quantity?: number
  owner?: String
  totalPrice?: number
}

export class Product implements IProduct {
  constructor(
    public id?: number,
    public name?: string,
    public details?: string,
    public sku?: string,
    public category?: string,
    public price?: number,
    public stocks?: number
  ) {}
}


export class Cart implements ICart {
  constructor(
    public productId?: number,
    public quantity?: number,
    public owner?: String,
    public totalPrice?: number
  ) {}
}
