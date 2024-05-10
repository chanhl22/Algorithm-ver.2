package question.trenbe;

public class Trend4 {
}

/**
 * NAME BOSS 을 조회
 * * BOSS 의 값이 비어있으면 CEO
 * * BOSS 의 값이 BOSS 를 가리키고 있으면 WORKER
 * * BOSS 의 값이 WORKER 를 가리키고 있으면 MANAGER
 */

//        SELECT ER.NAME,
//        (CASE
//        WHEN BOSS IS NULL THEN 'CEO'
//        WHEN BOSS = (
//        EXISTS (
//        SELECT NAME
//        FROM EMPLOYEE_RELATIONSHIPS
//        WHERE BOSS = ER.NAME
//        )
//        ) THEN 'WORKER'
//        ELSE 'MANAGER'
//        END) AS BOSS
//        FROM EMPLOYEE_RELATIONSHIPS AS ER

