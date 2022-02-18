CREATE DEFINER=`root`@`localhost` PROCEDURE `get_halal_stores`()
BEGIN
	Select s.*, r.name as region_name
    From store s
    Join region r on s.region_id = r.id
    Where s.id in
    (Select ps.store_id
	From product_store ps
    Join product p on ps.product_id = p.id
	Where ps.availability = 1 and ifnull(p.halal_status_id, 0) = 1
    Group By ps.store_id
    Having Count(*) > 1)
    Order By s.name;
END