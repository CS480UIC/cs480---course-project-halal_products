CREATE DEFINER=`root`@`localhost` PROCEDURE `get_store_by_region`(
	region_id_param int
)
BEGIN
	Select s.name as store_name, Case When ps.availability = 1 Then 'Yes' Else 'No' End 
    as availability, p.name as product_name, r.name as region_name,
    (Select name From manufacturer where id = p.manufacturer_id) as manufacturer_name
	From store s
	Join product_store ps on ps.store_id = s.id
	Join product p on ps.product_id = p.id
    Join region r on s.region_id = r.id
	Where p.halal_status_id = 1 and (region_id_param is null or 
    s.region_id = region_id_param)
	Order By r.name, ps.availability, s.name, p.name;
END