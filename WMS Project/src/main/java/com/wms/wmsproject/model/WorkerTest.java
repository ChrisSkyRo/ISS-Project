package com.wms.wmsproject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    @Test
    void testWorker() {
        Worker worker = new Worker("worker", "WorkerName", "password");
        assertNull(worker.getTasks());
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task();
        Task task2 = new Task();
        taskList.add(task1);
        taskList.add(task2);
        worker.setTasks(taskList);
        assertEquals(worker.getTasks(), taskList);
        assertEquals(worker.getTasks().get(0), task1);
        assertEquals(worker.getTasks().get(1), task2);
    }
}