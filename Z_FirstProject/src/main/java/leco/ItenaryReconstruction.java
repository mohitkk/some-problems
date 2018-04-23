package leco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItenaryReconstruction {

    public static void main(final String args[]) {
        final String[][] input = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
                { "ATL", "SFO" } };
        System.out.println(getItenary(input, "JFK"));
    }

    private static List<String> getItenary(final String[][] input, final String startD) {
        final List<List<Ticket>> result = new ArrayList<List<Ticket>>();
        final Map<String, List<Ticket>> tickets = new HashMap<String, List<Ticket>>();
        final int totalTickets = input.length;
        final List<Ticket> usedBucket = new ArrayList<Ticket>();
        final List<Ticket> notUsedBucket = new ArrayList<Ticket>();
        for (int i = 0; i < input.length; i++) {
            final String start = input[i][0];
            final String end = input[i][1];
            final Ticket ticket = new Ticket(start, end);
            notUsedBucket.add(ticket);
            if (tickets.containsKey(start)) {
                tickets.get(start).add(ticket);
            } else {
                final List<Ticket> destinations = new ArrayList<Ticket>();
                destinations.add(ticket);
                tickets.put(start, destinations);
            }
        }
        System.out.println(tickets);

        getItenary(tickets, totalTickets, notUsedBucket, usedBucket, result, new ArrayList<Ticket>(), startD);
        System.out.println(result);
        return getString(result.get(0));
    }

    private static List<String> getString(final List<Ticket> input) {
        final List<String> result = new ArrayList<String>();
        for (final Ticket each : input) {
            result.add(each.start);
        }

        return result;
    }

    private static void getItenary(final Map<String, List<Ticket>> ticketBucket, final int totalTickets,
            final List<Ticket> notUsedBucket,
            final List<Ticket> usedBucket, final List<List<Ticket>> result, final List<Ticket> currentItenary,
            final String start) {
        
        if (notUsedBucket.size() == 0) {
            final List<Ticket> aall = new ArrayList<Ticket>();
            aall.addAll(currentItenary);
            result.add(aall);
            return;
        }
        final List<Ticket> list = ticketBucket.get(start);
        for (final Ticket eachTicket : list) {
            if (!usedBucket.contains(eachTicket)) {
                usedBucket.add(eachTicket);
                currentItenary.add(eachTicket);
                notUsedBucket.remove(eachTicket);
                getItenary(ticketBucket, totalTickets, notUsedBucket, usedBucket, result, currentItenary,
                        eachTicket.end);
                notUsedBucket.add(eachTicket);
                usedBucket.remove(eachTicket);
                currentItenary.remove(eachTicket);
            }
        }

    }

    private static class Ticket {
        @Override
        public String toString() {
            return "Ticket [start=" + start + ", end=" + end + "]";
        }

        String start;
        String end;

        Ticket(final String start, final String end) {
            this.start = start;
            this.end = end;
        }

    }
}
