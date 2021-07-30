Use halal_products;

Select distinct p.*
From product p
Left Join product_store ps on ps.product_id = p.id
Where p.halal_status_id = 1 and (ps.availability is null or
ps.availability = 0)
Order By p.name;

Select distinct s.*
From store s
Join product_store ps on ps.store_id = s.id
Where ps.availability = 1 
Order By s.name;

Set @regionID = null;
Set @storeID = null;

Select *
From store s
Join product_store ps on ps.store_id = s.id
Join product p on ps.product_id = p.id
Where ps.availability = 1 and p.halal_status_id = 1 and 
(@regionID is null or s.region_id = @regionID)
Order By s.name, p.name;

Set @productName = null;
Set @zipCode = null;

Select *
From product p
Join product_store ps on ps.product_id = p.id
Join store s on ps.store_id = s.id
Where ps.availability = 1 and p.halal_status_id = 1 and
(@productName is null or p.name = @productName) and
(@zipCode is null or s.zipcode = @zipCode)
Order By s.name, p.name;

SELECT * FROM product_detail s;

