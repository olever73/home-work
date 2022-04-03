package de.telran.logentry;

/*
5. Есть class LogEntry{String login, String url}
Посчитать для каждого url, сколько раз он был тыкнут
* Посчитать количество уникальных посещений каждого url (необходимо обратить внимание на некоторые коллекторы, которые не были упомянуты на занятии)
* Вывести для каждого аккаунта Set посещенных страниц*/

public class LogEntry {
    String login;
    String url;

    public LogEntry(String login, String url) {
        this.login = login;
        this.url = url;
    }
    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

}
