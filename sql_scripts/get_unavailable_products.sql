CREATE DEFINER=`root`@`localhost` PROCEDURE `get_unavailable_products`()
BEGIN
	Select distinct p.*, m.name as manufacturer_name, c.name as category_name,
    ifnull(hs.status, 'NO')
	From product p
	Join manufacturer m on p.manufacturer_id = m.id
    Join product_category c on p.category_id = c.id
    Left Join halal_status hs on p.halal_status_id = hs.id
	Where ifnull(p.halal_status_id, 0) = 1 and (Select Count(*) From product_store ps 
    where ps.product_id = p.id and ps.availability = 1) = 0
    Order By p.name;
END