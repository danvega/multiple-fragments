# Spring Framework - Rendering Multiple Fragments

A new feature in Spring Framework 6.2.0 M5 is support for [rendering multiple fragments](https://github.com/spring-projects/spring-framework/issues/33162).

HTML focused libraries such as htmx.org and @hotwired/turbo with HTML-over-the-wire support use of multiple HTML fragments to update the page. The current assumption in Spring MVC and WebFlux, however, is that HTML rendering is with a single top-level view and model. There is no explicit support for rendering multiple fragments, each with its own model and view.

It is possible to do, and it is supported for example in htmx-spring-boot, but it is something we can help with to make it easier to write HTML-over-the-wire applications.

Originally this was requested in #27652. For this issue the goal is to add support for multiple fragments in a single response. After that can add support for rendering fragments over an Server-Sent Events stream.