package com.vinaylogics.schoolmanagement.repositories;

import com.vinaylogics.schoolmanagement.models.Attendance;
import com.vinaylogics.schoolmanagement.utils.QueryConstants;

/**
 * The interface AttendanceDao provides Data Access with Attendance table
 */
public interface AttendanceDao extends BaseDao<Attendance, Long> , QueryConstants.AttendanceTable {
}
