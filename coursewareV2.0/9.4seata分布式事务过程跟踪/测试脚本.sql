truncate table `order`.`order`; 
truncate table stock.stock;
insert into stock.stock values("001",100);

select * from `order`.`order`; 
select * from stock.stock;

-- 全局事务信息
select * from seata.global_table;

-- 运行每一个微服务更新sql时，会有记录
select * from seata.branch_table;

-- 锁信息
select * from seata.lock_table;

select *  from `order`.undo_log;

select *  from `stock`.undo_log;

select convert (rollback_info using utf8)  from `order`.undo_log
/*
{
	"@class": "io.seata.rm.datasource.undo.BranchUndoLog",
	"xid": "192.168.31.81:8091:6890819764518465835",
	"branchId": 6890819764518465838,
	"sqlUndoLogs": ["java.util.ArrayList", [{
		"@class": "io.seata.rm.datasource.undo.SQLUndoLog",
		"sqlType": "INSERT",
		"tableName": "`order`",
		"beforeImage": {
			"@class": "io.seata.rm.datasource.sql.struct.TableRecords$EmptyTableRecords",
			"tableName": "order",
			"rows": ["java.util.ArrayList", []]
		},
		"afterImage": {
			"@class": "io.seata.rm.datasource.sql.struct.TableRecords",
			"tableName": "order",
			"rows": ["java.util.ArrayList", [{
				"@class": "io.seata.rm.datasource.sql.struct.Row",
				"fields": ["java.util.ArrayList", [{
					"@class": "io.seata.rm.datasource.sql.struct.Field",
					"name": "id",
					"keyType": "PRIMARY_KEY",
					"type": 4,
					"value": 25
				}, {
					"@class": "io.seata.rm.datasource.sql.struct.Field",
					"name": "name",
					"keyType": "NULL",
					"type": 12,
					"value": "order1"
				}, {
					"@class": "io.seata.rm.datasource.sql.struct.Field",
					"name": "balance",
					"keyType": "NULL",
					"type": 7,
					"value": ["java.lang.Float", 128.78]
				}]]
			}]]
		}
	}]]
}
*/

