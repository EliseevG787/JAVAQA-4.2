package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.comparator.TicketByTimeAscComparator;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Comparator<Ticket> comparator = new TicketByTimeAscComparator();
    private Ticket ticket1 = new Ticket(1, 2111, "vko", "kzn", 90);
    private Ticket ticket2 = new Ticket(2, 2222, "vko", "kzn", 91);
    private Ticket ticket3 = new Ticket(3, 2333, "vko", "kzn", 92);
    private Ticket ticket4 = new Ticket(4, 2444, "vko", "kzn", 93);
    private Ticket ticket5 = new Ticket(5, 2555, "vko", "kzn", 94);
    private Ticket ticket6 = new Ticket(6, 2666, "svo", "jfk", 95);

    @Test
    void shouldFindAllIfEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("vko", "kzn", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllIfOne() {
        manager.add(ticket3);

        Ticket[] expected = new Ticket[]{ticket3};
        Ticket[] actual = manager.findAll("vko", "kzn", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        manager.add(ticket3);
        manager.add(ticket1);
        manager.add(ticket5);
        manager.add(ticket2);
        manager.add(ticket6);
        manager.add(ticket4);

        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.findAll("vko", "kzn", comparator);

        assertArrayEquals(expected, actual);
    }
}