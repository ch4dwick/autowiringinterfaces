# Autowiring Concrete classes of an interface in Spring

A while back I was faced with an ever growing REST method that had a long list of business rules to execute based on certain parameters. It all started with simple if-else if statements. 4 conditions. It was good for a time. That was, until the blocks of code inside them grew exponentially. The design quickly derailed into a spaghetti code of some sort even after moving all the contents into their own methods. It was bad design because there were fine-grained nuances to the rules that may apply to one parameter but not the other. Some would skip certain lines and some don't so I would still have to enter a deeper condition inside a method. An if within an if but not when that condition is met but not that. (The fact that I'm having a hard time describing this can give you an idea how much of a mess it was.) 

A pattern emerged from them. Although some lines of code appeared repeated it only seemed that way because some rules were simpler than others. I thought: what if I just loaded those rules on the fly without having to do tedious conditional clauses? On top of that the design had to be flexible enough so that if new rules emerged with each new parameter - there was only one common parameter that came above all the others - it would be in its own separate space.

So in essence:
``` java
@Autowired
InterfaceLoader loader;

@GetMapping("/submit")
public void submit(@RequestParam("flag") String flag) throws ClassNotFoundException {
  loader.loadClass(flag).doSomething(); // this was 400+ lines of spaghetti code!
}
```

Now I no longer need to worry about the nuances of different requirements in our project's context. I just tell my nifty little "class/component loader" what concrete class contains our business rules and execute it on the fly. I cut down the controller's old code by 50% (hey, don't judge. I was learning!). Ever since this change, I've had two business requiremetns come in after this change and I can tell you how much of a dream it is to just work on that requirement without having to worry about breaking the entire codebase. It's also easy to delegate the task to other devs without them ever breaking the other rules.

Interfaces and a delegation pattern would've been one obvious choice here but, wait, I was using Spring in our project! Out of curiosity I started looking around. I didn't want to fiddle with class loaders and lengthy reflection codes. (Typically, I would need it to find a concrete class of an interface from the classloader) By stroke of dumb luck I found out that Spring can auto-wire a collection containing all concrete classes - of components/beans/services - of an interface. One Set of all my related concrete classes in one nifty auto-wired variable. The codes that are in this repository is the outcome of that work. I understand that the concepts here are rudimentary stuff for Spring but if you ever want to see an application of such concepts, this is it.

## References
1. https://dzone.com/articles/load-all-implementors
2. https://stackoverflow.com/questions/7446301/autowire-reference-beans-into-list-by-type
