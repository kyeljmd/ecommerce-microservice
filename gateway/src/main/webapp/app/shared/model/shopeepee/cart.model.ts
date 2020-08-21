export interface ICart {
  id?: number;
  quantity?: number;
  owner?: string;
  productId?: number;
  totalPrice?: number;
}

export class Cart implements ICart {
  constructor(public id?: number, public quantity?: number, public owner?: string, public productId?: number, public totalPrice?: number) {}
}
