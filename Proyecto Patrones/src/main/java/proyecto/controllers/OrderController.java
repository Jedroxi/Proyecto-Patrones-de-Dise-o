package proyecto.controllers;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public interface OrderController {
    void create(@NotNull Context context);

    void find(@NotNull Context context);

    void findAll(@NotNull Context context);

    void update(@NotNull Context context);

    void delete(@NotNull Context context);

    void proxAprobador(@NotNull Context context);

    void findOrdersByUser(@NotNull Context context);
}