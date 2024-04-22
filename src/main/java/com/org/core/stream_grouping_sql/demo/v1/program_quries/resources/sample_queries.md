### Question:: 
write a sql query to transform below table
id | name | subject_name | marks
---------------------------------------
1| subho | science| 85
2|sham | math | 98
3| subho | math | 77
4| queen | geography | 87

to below one

id | name | subject_name1 | marks | subject_name2 | marks | subject_name3 | marks
---------------------------------------
1| subho | science| 85 | math | 77| geography | 0
2|sham | science| 0 | math | 98| geography | 0
3| queen | science| 0 | math | 98| geography | 87

### Answer::
```
SELECT
    t1.id,
    t1.name,
    COALESCE(t2.subject_name, 'science') AS subject_name1,
    COALESCE(t2.marks, 0) AS marks1,
    COALESCE(t3.subject_name, 'math') AS subject_name2,
    COALESCE(t3.marks, 0) AS marks2,
    COALESCE(t4.subject_name, 'geography') AS subject_name3,
    COALESCE(t4.marks, 0) AS marks3
FROM
    (SELECT DISTINCT id, name FROM your_table) t1
LEFT JOIN
    your_table t2 ON t1.id = t2.id AND t2.subject_name = 'science'
LEFT JOIN
    your_table t3 ON t1.id = t3.id AND t3.subject_name = 'math'
LEFT JOIN
    your_table t4 ON t1.id = t4.id AND t4.subject_name = 'geography';

```


1. **Calculate Total Marks for Each Student:**
```sql
SELECT id, name, SUM(marks) AS total_marks
FROM your_table
GROUP BY id, name;
```

2. **Calculate Average Marks for Each Subject:**
```sql
SELECT subject_name, AVG(marks) AS average_marks
FROM your_table
GROUP BY subject_name;
```

3. **Find Students with Maximum Marks in Each Subject:**
```sql
SELECT subject_name, name, marks
FROM (
    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY subject_name ORDER BY marks DESC) AS rank
    FROM your_table
) ranked
WHERE rank = 1;
```

4. **Find Subject with Maximum Marks and Student Name:**
```sql
SELECT subject_name, name, marks
FROM your_table
WHERE (subject_name, marks) IN (
    SELECT subject_name, MAX(marks)
    FROM your_table
    GROUP BY subject_name
);
```

5. **Calculate Rank of Each Student based on Total Marks:**
```sql
SELECT id, name, total_marks,
       DENSE_RANK() OVER (ORDER BY total_marks DESC) AS rank
FROM (
    SELECT id, name, SUM(marks) AS total_marks
    FROM your_table
    GROUP BY id, name
) total_marks_per_student;
```

These queries demonstrate various types of analysis that can be performed on the given table, such as calculating totals, averages, finding maximums, and ranking. Adjust them as needed based on your specific requirements.


