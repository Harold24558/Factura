import { FacturaPage } from './app.po';

describe('factura App', function() {
  let page: FacturaPage;

  beforeEach(() => {
    page = new FacturaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
