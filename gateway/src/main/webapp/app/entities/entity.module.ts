import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'product',
        loadChildren: () => import('./shopeepee/product/product.module').then(m => m.ShopeepeeProductModule),
      },
      {
        path: 'cart',
        loadChildren: () => import('./shopeepee/cart/cart.module').then(m => m.ShopeepeeCartModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class GatewayEntityModule {}
