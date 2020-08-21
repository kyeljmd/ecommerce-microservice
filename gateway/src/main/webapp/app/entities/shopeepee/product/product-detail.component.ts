import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ICart, Cart } from 'app/shared/model/shopeepee/cart.model';
import { IProduct } from 'app/shared/model/shopeepee/product.model';
import { CartService }  from 'app/shared/service/cart.service';

import { Observable } from 'rxjs';

@Component({
  selector: 'jhi-product-detail',
  templateUrl: './product-detail.component.html',
})
export class ProductDetailComponent implements OnInit {
  product: IProduct | null = null;
  isSaving = false;
  cartForm = this.fb.group({
    id: [],
    quantity: [],
    owner: [],
    productId: [],
  });

  constructor(protected activatedRoute: ActivatedRoute,  private fb: FormBuilder,protected cartService: CartService) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ product }) => {
      this.product = product;

      });
  }

  addToCart(): void {
    this.isSaving = true;
        const cart = this.createFromForm();
    cart.productId = this.product?.id
    // eslint-disable-next-line no-console
    console.log(cart)
    this.subscribeToSaveResponse(this.cartService.create(cart));
  }
  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICart>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  private createFromForm(): ICart {
    return {
      ...new Cart(),
      id: this.cartForm.get(['id'])!.value,
      quantity: this.cartForm.get(['quantity'])!.value,
      owner: this.cartForm.get(['owner'])!.value,
      productId: this.cartForm.get(['productId'])!.value,
    };
  }

  previousState(): void {
    window.history.back();
  }
}
