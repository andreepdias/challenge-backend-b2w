SELECT
	*
FROM (
	SELECT 
		event_type,
	    (LEAD(value) OVER (PARTITION BY event_type ORDER BY time ASC) - value) AS value
	FROM events 
	ORDER BY time ASC
    ) AS quertDiffBetweenPreviousAndCurrent
GROUP BY event_type
HAVING COUNT(event_type) > 1
ORDER BY event_type