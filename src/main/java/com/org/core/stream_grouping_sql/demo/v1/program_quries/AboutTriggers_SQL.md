## Describe different typed of trigger
Triggers in SQL are special types of stored procedures that are automatically executed or fired in response to specific events or actions occurring in a database. There are mainly four types of triggers based on the triggering event and the timing of execution:

### BEFORE Trigger:

A BEFORE trigger is fired before the execution of a DML (Data Manipulation Language) operation such as INSERT, UPDATE, or DELETE.
It can be used to perform validation or modification of data before it is actually inserted, updated, or deleted.
Example:
```
CREATE TRIGGER before_insert_trigger
BEFORE INSERT ON table_name
FOR EACH ROW
BEGIN
    -- Trigger logic
    IF NEW.column_name < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Value cannot be negative';
    END IF;
END;
```

### AFTER Trigger:

An AFTER trigger is fired after the execution of a DML operation.
It is commonly used for auditing, logging, or post-processing tasks after data modification operations.
Example:
```
CREATE TRIGGER after_update_trigger
AFTER UPDATE ON table_name
FOR EACH ROW
BEGIN
    -- Trigger logic
    INSERT INTO audit_table (event_type, event_timestamp, user_id)
    VALUES ('UPDATE', NOW(), CURRENT_USER());
END;
```


### INSTEAD OF Trigger:

An INSTEAD OF trigger is fired instead of the default action associated with an INSERT, UPDATE, or DELETE operation on a view.
It allows custom processing or handling of the action before it is performed on the underlying base tables of the view.
Example:
```
CREATE TRIGGER instead_of_delete_trigger
INSTEAD OF DELETE ON view_name
FOR EACH ROW
BEGIN
    -- Trigger logic
    UPDATE table1 SET is_deleted = 1 WHERE id = OLD.id;
END;
```


### COMPOUND Trigger:

A COMPOUND trigger is a combination of BEFORE and AFTER triggers that are fired for the same triggering event.
It allows for complex processing involving both pre- and post-action logic.
Example:
```
CREATE OR REPLACE TRIGGER compound_trigger
FOR INSERT OR UPDATE OR DELETE ON table_name
COMPOUND TRIGGER

    BEFORE STATEMENT IS
    BEGIN
        -- Trigger logic before statement execution
    END BEFORE STATEMENT;

    AFTER EACH ROW IS
    BEGIN
        -- Trigger logic after each row
    END AFTER EACH ROW;

    AFTER STATEMENT IS
    BEGIN
        -- Trigger logic after statement execution
    END AFTER STATEMENT;

END compound_trigger;
```


