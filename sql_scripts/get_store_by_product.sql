CREATE DEFINER=`root`@`localhost` PROCEDURE `get_store_by_product`(
	product_name_param varchar(200),
    zipcode_param int
)
BEGIN
	Select s.*, p.name as product_name
	From product p
	Join product_store ps on ps.product_id = p.id
	Join store s on ps.store_id = s.id
	Where ps.availability = 1 and ifnull(p.halal_status_id, 0) = 1 and
	p.name like concat('%', product_name_param, '%') and
	(zipcode_param is null or s.zipcode = @zipCode)
	Order By s.zipcode, s.name, p.name;
END